public class Task {
    private Long digitOfPi;
    
    Task(Long digitOfPi) {
        this.digitOfPi = digitOfPi;
    }

    public String completeTask() {
        Bpp bpp = new Bpp();
        String workingString = Integer.toString(bpp.getDecimal(digitOfPi));
        String finalString = "";
        if (workingString.length() == 9) {
            finalString += workingString.charAt(0);
        } else {
            finalString += "0";
        }
        return finalString;
    }

    public Long getDigitOfPi() {
        return this.digitOfPi;
    }
}
