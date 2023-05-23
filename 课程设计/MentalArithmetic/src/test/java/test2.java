import com.zz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 朱喆
 * @version 1.0
 */

public class test2 {


    private static UserService userService;

    public static void main(String[] args) {
        System.out.println(userService);
    }

}
