import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * Hello world!
 *
 */
public class Applicaiton {
    //定义mock服务的端口
    private static final int PORT=9090;
    //定义mock服务的地址
    private static final String LOCALHOST="localhost";
    //定义mapping文件目录
    private static final String MOCK_DIR="mock";
    //main方法中的内容为启动mock服务的固定写法
    //该代码作用是启动一个 Mock 服务，并定义服务的 Host 是localhost，端口是9090，
    // MOCK_DIR 的值设置为 Mock ，作用是告知 Mock 服务接口的 mapping 文件和 response 文件
    // 放在项目目录的 resources 下面的 Mock folder 内
    public static void main(String[] args){
        final WireMockConfiguration config=wireMockConfig()
                .port(PORT)
                .usingFilesUnderClasspath(MOCK_DIR);
        final WireMockServer WireMockServer = new WireMockServer(config);
        WireMockServer.start();
        WireMock.configureFor(LOCALHOST,PORT);
    }
}

