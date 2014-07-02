package cn.home.paradigm;

import java.util.Collection;
import java.util.List;

/**
 * <br/>Title: Generics
 * <br/>Description:TODO
 * <br/>Company: ChinaBank
 * <br/>ClassName: Generics
 * <br/>ProjectName: opencode-common
 * <br/>author qinhaihong
 * <br/>date 2013年10月18日 上午10:55:58
 * <br/>version 1.0.0
 */
public class Generics<T extends List<?>> {
		
	public static void main(String[] args) {
		@SuppressWarnings({ "rawtypes", "unused" })
		Generics<? extends Collection> generics = new Generics<List>();
	}

}
