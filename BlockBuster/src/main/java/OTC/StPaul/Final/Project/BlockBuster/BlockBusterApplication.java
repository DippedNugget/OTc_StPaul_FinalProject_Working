package OTC.StPaul.Final.Project.BlockBuster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import OTC.StPaul.Final.Project.*;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class }) 
public class BlockBusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockBusterApplication.class, args);
	}

}
