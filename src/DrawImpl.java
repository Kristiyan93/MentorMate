public class DrawImpl implements Draw {
    private Short digit;

    public DrawImpl(Short digit) {
        setDigit(digit);
    }

    private void setDigit(Short digit) {
        if (digit < 2 || digit > 10000) {
            throw new IllegalArgumentException("2 < N < 10 000, N must be odd digit");
        }

        this.digit = digit;
    }

    @Override
    public String getPrint() {
        StringBuilder sb = new StringBuilder();

        int n = this.digit;

        addTop(sb, n);
        addCenter(sb, n);
        addBot(sb, n);

        return sb.toString();
    }

    private void addBot(StringBuilder sb, int n) {
        for (int i = 0; i < n / 2 - 1; i++) {
            sb.append(repeatStr(DASH, n / 2 - i - 1)
                    + repeatStr(STAR, n)
                    + repeatStr(DASH, 3 + (2 * i))
                    + repeatStr(STAR, (n * 2) - 3 - (i * 2))
                    + repeatStr(DASH, 3 + (2 * i))
                    + repeatStr(STAR, n)
                    + repeatStr(DASH, n / 2 - i - 1)
                    + repeatStr(DASH, n / 2 - i - 1)
                    + repeatStr(STAR, n)
                    + repeatStr(DASH, 3 + (2 * i))
                    + repeatStr(STAR, (n * 2) - 3 - (i * 2))
                    + repeatStr(DASH, 3 + (2 * i))
                    + repeatStr(STAR, n)
                    + repeatStr(DASH, n / 2 - i - 1)).append(System.lineSeparator());
        }

        sb.append(repeatStr(STAR, n) + repeatStr(DASH, n) + repeatStr(STAR, n)
                + repeatStr(DASH, n) + repeatStr(STAR, n) + repeatStr(STAR, n)
                + repeatStr(DASH, n) + repeatStr(STAR, n)
                + repeatStr(DASH, n) + repeatStr(STAR, n));
    }

    private void addCenter(StringBuilder sb, int n) {
        sb.append(repeatStr(DASH, n / 2)
                + repeatStr(STAR, n)
                + repeatStr(DASH, 1)
                + repeatStr(STAR, n * 2 - 1)
                + repeatStr(DASH, 1)
                + repeatStr(STAR, n)
                + repeatStr(DASH, n / 2)
                + repeatStr(DASH, n / 2)
                + repeatStr(STAR, n)
                + repeatStr(DASH, 1)
                + repeatStr(STAR, n * 2 - 1)
                + repeatStr(DASH, 1)
                + repeatStr(STAR, n)
                + repeatStr(DASH, n / 2)).append(System.lineSeparator());
    }

    private void addTop(StringBuilder sb, int n) {
        sb.append(repeatStr(DASH, n))
                .append(repeatStr(STAR, n))
                .append(repeatStr(DASH, n))
                .append(repeatStr(STAR, n))
                .append(repeatStr(DASH, n))
                .append(repeatStr(DASH, n))
                .append(repeatStr(STAR, n))
                .append(repeatStr(DASH, n))
                .append(repeatStr(STAR, n))
                .append(repeatStr(DASH, n))
                .append(System.lineSeparator());

        for (int i = 0; i < n / 2; i++) {
            sb.append(getStr(n, i)).append(getStr(n, i)).append(System.lineSeparator());
        }
    }

    private static String getStr(int n, int i) {
        String str = repeatStr(DASH, n - 1 - i)
                + repeatStr(STAR, n + 2 + (i * 2))
                + repeatStr(DASH, n - 2 - (i * 2))
                + repeatStr(STAR, n + 2 + (i * 2))
                + repeatStr(DASH, n - 1 - i);

        return str;
    }

    private static String repeatStr(String str, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(str);
        }

        return sb.toString();
    }
}
