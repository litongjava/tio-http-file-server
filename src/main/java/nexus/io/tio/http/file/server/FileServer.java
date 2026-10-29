package nexus.io.tio.http.file.server;

import nexus.io.context.BootConfiguration;
import nexus.io.tio.boot.TioApplication;
import nexus.io.tio.boot.http.handler.common.HttpFileDataHandler;
import nexus.io.tio.boot.server.TioBootServer;
import nexus.io.tio.http.server.router.HttpRequestRouter;

public class FileServer {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    TioApplication.run(new BootConfiguration() {

      @Override
      public void config() throws Exception {
        TioBootServer server = TioBootServer.me();
        HttpRequestRouter requestRouter = server.getRequestRouter();

        requestRouter.get("/**", new HttpFileDataHandler(false));
      }
    }, args);
    long end = System.currentTimeMillis();
    System.out.println((end - start) + "ms");
  }
}
