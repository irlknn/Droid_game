import java.io.PrintStream;

class TeeStream extends PrintStream {
    private final PrintStream secondStream;

    public TeeStream(PrintStream mainStream, PrintStream secondStream) {
        super(mainStream);
        this.secondStream = secondStream;
    }

    @Override
    public void write(byte[] buf, int off, int len) {
        try {
            super.write(buf, off, len);
            secondStream.write(buf, off, len);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void flush() {
        super.flush();
        secondStream.flush();
    }
}

