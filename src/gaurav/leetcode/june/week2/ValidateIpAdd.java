package gaurav.leetcode.june.week2;

public class ValidateIpAdd {
    private final static int V4 = 1;
    private final static int V6 = 2;

    public String validIPAddress(String ip) {

        int ipType = -1;

        if (ip.contains(".")) {
            ipType = V4;
        } else if (ip.contains(":")) {
            ipType = V6;
        }

        switch (ipType) {
            case V4:
                return handleV4(ip);
            case V6:
                return handleV6(ip);

            default:
                return "Neither";
        }
    }

    private String handleV4(String ip) {
        if (ip.charAt(ip.length() - 1) == '.') {
            return "Neither";
        }
        String[] parts = ip.split("\\.");
        if (parts.length == 4) {
            for (String p : parts) {
                if ((p.length() > 0 && p.charAt(0) != '0' && p.charAt(0) != '-') || (p.length() == 1 && p.charAt(0) == '0')) {
                    try {
                        int val = Integer.parseInt(p);
                        if (val < 0 || val > 255) {
                            return "Neither";
                        }
                    } catch (Exception e) {
                        return "Neither";
                    }

                } else {
                    return "Neither";
                }
            }
        } else {
            return "Neither";
        }

        return "IPv4";
    }

    private String handleV6(String ip) {
        if (ip.charAt(ip.length() - 1) == ':') {
            return "Neither";
        }
        String[] parts = ip.split(":");

        if (parts.length == 8) {
            for (String p : parts) {
                if (p.length() <= 4 && p.length()>0) {
                    for (int c : p.toCharArray()) {
                        if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                            return "Neither";
                        }
                    }
                } else {
                    return "Neither";
                }
            }
        } else {
            return "Neither";
        }


        return "IPv6";

    }

    public String validIPAddress2(String IP) {
        boolean fail = false;
        if (IP.indexOf(".") > 0 && !IP.startsWith(".") && !IP.endsWith(".")) {
            String[] parts = IP.split("\\.");
            if (parts.length == 4) {
                for (String p : parts) {
                    for (char c : p.toCharArray())
                        if (!Character.isDigit(c))
                            fail = true;

                    if (fail || p.length() == 0 || p.length() > 3 || (p.charAt(0) == '0' && p.length() > 1) || Integer.valueOf(p) >= 256)
                        fail = true;
                }
                if (!fail) return "IPv4";
            }
        } else if (IP.indexOf(":") > 0 && !IP.startsWith(":") && !IP.endsWith(":")) {
            String[] parts = IP.split(":");
            if (parts.length == 8) {
                for (String p : parts) {
                    for (char c : p.toCharArray())
                        if ((!Character.isDigit(c) && !Character.isLetter(c)) || (c >= 'G' && c <= 'Z') || (c >= 'g' && c <= 'z'))
                            fail = true;

                    if (fail || p.length() == 0 || p.length() > 4) fail = true;
                }
                if (!fail) return "IPv6";
            }
        }
        return "Neither";
    }


    public static void main(String[] args) {
        System.out.println(new ValidateIpAdd().validIPAddress("2001:0db8:85a3:033:0:8A2E:0370:7334"));
    }
}
