public class SecurePassword {
    // instance variable
    private String password;

    // constructor
    public SecurePassword(String password) {
        this.password = password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public boolean isSecure() {
        if (isLongEnough() && containsUppercase() && containsLowercase() && containsDigit() && containsSpecialSymbol()){
            return true;
        }
        return false;
    }

    public String status() {
        if (isSecure()){
            return "Password is secure";
        } else{
            String returnStatement = "";
            if (!isLongEnough()){
                returnStatement += "The password must be at least 8 characters.\n";
            }
            if(!containsUppercase()){
                returnStatement+= "The password must contain at least one uppercase letter.\n";
            }
            if(!containsLowercase()){
                returnStatement += "The password must contain at least one lowercase letter.\n";
            }
            if (!containsDigit()){
                returnStatement+= "The password must contain at least one numeric digit.\n";
            }
            if (!containsSpecialSymbol()) {
                returnStatement+= "The password must contain a special symbol: ! @ # $ % ^ & * ?\n";
            }
            return returnStatement;
        }

    }

    private boolean isLongEnough() {
        if (password.length() >= 8){
            return true;
        }
        return false;
    }

    private boolean containsUppercase() {
        /* this one is completed for you as a hint for how to do the others! */
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return checkString(upperCaseLetters);  // this method implemented below
    }

    private boolean containsLowercase() {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        return checkString(lowerCaseLetters);
    }

    private boolean containsDigit() {
        String numbers = "1234567890";
        return checkString(numbers);
    }

    private boolean containsSpecialSymbol() {
        String specialSymbols = "!@#$%^&*?";
        return checkString(specialSymbols);
    }

    private boolean checkString(String characterString) {
        String currentLetter = "";
        for (int i=0; i<=characterString.length()-1; i++){
            currentLetter = characterString.substring(i,i+1);
            for (int j=0; j<=password.length()-1; j++){
                if (password.substring(j,j+1).equals(currentLetter)){
                    return true;
                }
            }
        }
        return false;
    }
}

