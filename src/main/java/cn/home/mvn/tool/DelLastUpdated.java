package cn.home.mvn.tool;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>Title: DelLastUpdated</p>
 * <p>Description: 解决.lastUpdated文件，会导致m2e工具无法找到依赖的jar包，从而提示编译错误的问题</p>
 * <p>Company: ChinaBank</p>
 * @ClassName: DelLastUpdated
 * @author qinhaihong
 * @date 2013年9月3日 下午3:27:55
 * @version 1.0.0
 */
public class DelLastUpdated {
	private static final String CONFIGURE_FILE = "m2e";
	private static final String KEY_MAVEN_REPO = "maven.repo";
	private static final String FILE_SUFFIX = "lastUpdated";
	
	private static PropertyHelper propHelper = new PropertyHelper(CONFIGURE_FILE);
	private static final String MAVEN_REPO_PATH = propHelper.getValue(KEY_MAVEN_REPO);
	private static final Log _log = LogFactory.getLog(DelLastUpdated.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File mavenRep = new File(MAVEN_REPO_PATH);
		if (!mavenRep.exists()) {
			_log.warn("Maven repos is not exist.");
			return;
		}
		File[] files = mavenRep.listFiles((FilenameFilter) FileFilterUtils.directoryFileFilter());
		delFileRecr(files, null);
		_log.info("Clean lastUpdated files finished.");
	}

	private static void delFileRecr(File[] dirs, File[] files) {
		if (dirs != null && dirs.length > 0) {
			for(File dir: dirs){
				File[] childDir = dir.listFiles((FilenameFilter) FileFilterUtils.directoryFileFilter());
				File[] childFiles = dir.listFiles((FilenameFilter) FileFilterUtils.suffixFileFilter(FILE_SUFFIX));
				delFileRecr(childDir, childFiles);
			}
		}
		if(files!=null && files.length>0){
			for(File file: files){
				if(file.delete()){
					_log.info("File: ["+file.getName()+"] has been deleted.");
				}
			}
		}
	}

}
