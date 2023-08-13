import cn.hutool.core.date.DateTime;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author 阿泽
 * @create 2021-04-22-17:05
 */

@RunWith(SpringJUnit4ClassRunner.class)

public class ControllerTest {

    @Test
    public void Hello() {
        System.out.println("nihao");
    }

}
