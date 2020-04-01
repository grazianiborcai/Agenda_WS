package br.com.mind5.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ActionMapOption<T,S> {
	public Connection conn; 
	public String schemaName; 
	public List<T> recordInfos; 
	public Class<? extends ActionVisitorAction<T>> visitorAction; 
	public Class<? extends ActionVisitorMap<T,S>> visitorMap;
	
	
	
	public static <T,S> ActionMapOption<T,S> copyFromTreeOption(DeciTreeOption<T> treeOption) {
		checkArgument(treeOption);
		
		ActionMapOption<T,S> option = new ActionMapOption<>();
		
		option.conn = treeOption.conn; 
		option.schemaName = treeOption.schemaName; 
		option.recordInfos = treeOption.recordInfos; 
		
		return option;
	}
	
	
	
	private static <T> void checkArgument(DeciTreeOption<T> treeOption) {
		if (treeOption == null) {
			logException(new NullPointerException("treeOption" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("treeOption" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	static private void logException(Exception e) {
		SystemLog.logError(ActionMapOption.class, e);
	}
}
