import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class EmailValidator {
private Pattern pattern;
private Matcher m;
private  String EmailPattern="^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$";
public EmailValidator(){
pattern=Pattern.compile(EmailPattern);
}
public boolean validate(final String hexa){
    m=pattern.matcher(hexa);
    return m.matches();
}
}
