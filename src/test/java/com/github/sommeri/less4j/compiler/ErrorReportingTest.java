package com.github.sommeri.less4j.compiler;

import java.io.File;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.sommeri.less4j.utils.w3ctestsextractor.TestFileUtils;

@RunWith(Parameterized.class)
//@Ignore //not really sure yet how do I want to handle errors
public class ErrorReportingTest extends AbstractErrorReportingTest {

  private static final String cases = "src/test/resources/error-handling/";

  public ErrorReportingTest(File lessFile, File errorList, String testName) {
    super(lessFile, errorList, testName);
  }

  @Parameters()
  public static Collection<Object[]> allTestsParameters() {
    return (new TestFileUtils(".txt")).loadTestFiles(cases);
  }
}
