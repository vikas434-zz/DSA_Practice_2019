package LeetCode;

import java.util.HashSet;

public class UniqueEmailAddress {

    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();
        for(int i =0; i<emails.length; i++) {
            String[] emailSplit = emails[i].split("@");

            StringBuilder domainName = new StringBuilder(emailSplit[1]);

            String localNameWithoutPlus = emailSplit[0].split("[+]")[0];// If there is no plus localName will be as it is.

            StringBuilder localNameWithoutPlusWithoutDot = getStringWithoutDot(localNameWithoutPlus);
            uniqueEmails.add(localNameWithoutPlusWithoutDot.append("@").append(domainName).toString());
        }
        return uniqueEmails.size();
    }

    private StringBuilder getStringWithoutDot(String localNameWithoutPlus) {
        StringBuilder sb = new StringBuilder();
        for(char c : localNameWithoutPlus.toCharArray()) {
            if(c != '.') {
                sb.append(c);
            }
        }
        return sb;
    }
}
