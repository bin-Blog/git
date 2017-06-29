import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Generator {
	@Test
	public void  TestGenerator() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("src/main/resources/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		System.out.println(cp);
		Configuration config = cp.parseConfiguration(configFile);
		System.out.println(config);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		System.out.println(callback);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
		System.out.println("SUCCESS");
	}
}
