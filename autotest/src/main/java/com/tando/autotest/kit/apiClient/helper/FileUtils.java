package tools.apiClient.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * General File utilities.
 * This class provides static utility methods for file operations.
 *
 */
public class FileUtils {

  /**
   * Read the data from the file and return as String.
   * @param file
   * @return String
   */
  public static String loadFile(String file)
  {
    try
    {
      String content = IOUtils.toString(new ClassPathResource(file).getInputStream());
      return (String)new SpelExpressionParser().parseExpression(content, new TemplateParserContext()).getValue();
    }
    catch(IOException e)
    {
      throw new RuntimeException("problem loading file: " + file);
    }
  }
  
  /**
   * Read the data from the property file and return as Properties<key, value>.
   * @param file
   * @return String
   */
  public Properties loadPropertyFile(String file) 
  {
    Properties prop = new Properties();
    try {

        BufferedReader brProp = new BufferedReader(new FileReader(file));
        prop.load(brProp);
        brProp.close();
    }
    catch (IOException e) {
        throw new IllegalStateException("problem loading file: " + file, e);
    }
    return prop;
}
  
  
}