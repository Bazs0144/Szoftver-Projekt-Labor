package proto;

/*
   BufferedCanvas.java

   Written 1999 by Keunwoo Lee (klee@cs)

   Generic double-buffered animating canvas class.  Derived directly
   from ideas and code found in Ken Perlin's double-buffered applet
   class (mrl.nyu.edu/perlin).

   NOTES:

   - To define your own double-buffering canvas component, you can
   simply subclass this class and redefine the render() method (see
   comments below).

   - Note my extensive use of Javadoc comments.  Know them, use them.

   - Read all the comments to learn more about this code and the Java
   AWT.  It may seem overwhelming, but you don't have to absorb it all
   at once.  If you don't understand something, look it up in the
   class documentation.  The ability to educate yourself is the single
   most valuable programming skill I know of.

   - If you want only double-buffering, but no animation (i.e., you
   only want to redraw on specific events, rather than every N
   milliseconds), you can hack out the thread code, which shouldn't be
   too hard.

   - Also note that you will not want to use naively a large number of
   of BufferedCanvas instances, because they each create a thread.
   You would instead want to write a generic "callback server" thread
   that would periodically call the repaint() methods of a number of
   client canvases.  You might call the client interface
   RedrawListener and make it behave much like event listeners in the
   AWT.  This is left as an exercise to the reader :).

*/

import java.awt.*;

/** Abstract base class for double-buffered animating Components.
 (Note that Canvas is a subclass of Component; see AWT docs.) */
public abstract class BufferedCanvas
        extends Canvas
{
    /** Public constant, just so clients will know what to expect when
     they create a default BufferedCanvas. */
    public static final int DEFAULT_REFRESH_RATE = 30;

    /** ATTENTION SUBCLASS IMPLEMENTORS: Here's the only abstract
     method.  Subclasses can simply render to this graphics
     context, and not worry about all the other details.  This is
     part of the power of OO design. */
    public abstract void render(Graphics g);

    //////////////////////////////////////////////////////////////////////
    // PRIVATE & PROTECTED FIELDS

    // Refresh rate; i.e., how often (on average) should this canvas
    // be redrawn?
    private int refresh_rate = DEFAULT_REFRESH_RATE;

    private Image bufferImage = null;        // Image for the double buffer
    private Graphics bufferGraphics = null;  // Graphics context for double buffer
    private CallbackThread callback;         // Thread class (inner class, see below)

    // Has the canvas been resized?  We don't need this information,
    // but it may be useful to subclasses.
    protected boolean sizeChanged = true;

    // Bounding box for double buffer.  We'll resize this later, when
    // we know the size of the canvas.  The reason we don't know the
    // size right away is that the size of a Component can be changed
    // at any time by the LayoutManager of the containing Component.
    protected Rectangle bounds = new Rectangle(0,0,0,0);

    //////////////////////////////////////////////////////////////////////
    // PUBLIC METHODS

    /** Starts a callback thread (i.e., begin animation).  If you
     write e.g. an applet, you will want to call this at some point
     in the applet's start() method. */
    public void start() {
        callback = new CallbackThread();
        callback.start();
    }
    public void stop()  { callback.killed = true; }

    /** This class supports paused animations. */
    public void setPaused(boolean paused) {callback.setPaused(paused);}
    public boolean isPaused() {return callback.isPaused();}

    /** ...and user-defined refresh rate.  If you want very infrequent
     updates (e.g., you have a graph class that represents data
     that only updates once per second), you can slow down the
     refresh rate and gain efficiency. */
    public void setRefreshRate(int milliseconds)
    {
        this.refresh_rate = milliseconds;
    }
    public int getRefreshRate() { return refresh_rate; }

    /** OK, so here's a little tutorial on how AWT components draw
     themselves.  First, the Component base class defines a
     repaint() method.  Whenever the somebody (e.g., the AWT window
     manager) wants a component to repaint itself, it will call
     repaint().  You can also call repaint() manually.

     repaint() causes the current object's update() method to be
     called with an appropriate Graphics context for this
     component.  The default implementation of update() simply does
     the following:

     1. Clears the screen
     2. Sets the Graphics context to draw the appropriate
     background and foreground colors of this component (see
     the docs for getBackground(), etc. in
     java.awt.Component).
     3. Calls the paint() method of the current object.

     However, obviously we want to change how update() works.  For
     double-buffered animation, there's no reason whatsoever to
     clear the screen.  So instead of doing that and calling
     paint(), we just render and draw the buffer directly.

     There are some details of course...
     */
    public void update(Graphics g) {
        // Whenever canvas changes size, create a new double buffer,
        // and tell application we have changed
        if (bounds.width != getBounds().width
                || bounds.height != getBounds().height) {
            bounds = getBounds();
            bufferImage    = createImage(bounds.width, bounds.height);
            bufferGraphics = bufferImage.getGraphics();
            sizeChanged = true;
        }

        // Subclasses should render to the double buffer
        render(bufferGraphics);
        sizeChanged = false;
        g.drawImage(bufferImage,0,0,this);
    }

    /** Threading class.  The main BufferedCanvas spawns an instance
     of this class in order to control the animation thread. */
    private class CallbackThread
            extends Thread
    {
        private boolean paused = false;
        private boolean killed = false;
        private long interval = 0;

        public CallbackThread() {}

        public void setPaused(boolean p) {paused = p;}
        public boolean isPaused() {return paused;}

        // When the start() method (inherited from Thread) is called,
        // the JVM will start up a new thread of execution and call
        // the run() method of the thread.  The default Thread.run()
        // method does nothing; this one loops until the thread is
        // killed, calling sleep() when it's done repainting the
        // current frame.
        public void run() {
            try {
                while (!killed) {
                    if (!paused) {
                        // Notice that I use the OuterClassName.this
                        // optional prefix.  IMHO this syntax is a bit
                        // awkward and ugly, but c'est la vie.
                        BufferedCanvas.this.repaint();
                    }
                    sleep(BufferedCanvas.this.refresh_rate);
                }
            } catch (InterruptedException e) {}
        }
    }

}
