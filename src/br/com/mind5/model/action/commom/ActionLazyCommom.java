package br.com.mind5.model.action.commom;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ActionLazyCommom<T extends InfoRecord> extends ActionLazyTemplate<T, T> {
	private final Class<? extends ActionVisitor<T>> visitorClass;
	

	public ActionLazyCommom(Connection conn, String schemaName, Class<? extends ActionVisitor<T>> actionVisitorClazz) {
		super(conn, schemaName);
		
		checkArgument(actionVisitorClazz);
		visitorClass = actionVisitorClazz;
	}
	
	
	
	@Override protected List<T> translateRecordInfosHook(List<T> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<T> getInstanceOfActionHook(DeciTreeOption<T> option) {
		return new ActionStdCommom<T>(option, visitorClass);
	}
	
	
	
	@Override protected DeciResult<T> translateResultHook(DeciResult<T> result) {
		return result;
	}
	
	
	
	private void checkArgument(Class<? extends ActionVisitor<T>> actionVisitor) {
		if (actionVisitor == null) {
			super.logException(new NullPointerException("actionVisitor" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("actionVisitor" + SystemMessage.NULL_ARGUMENT);
		}
	}
}
