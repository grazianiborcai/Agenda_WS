package br.com.mind5.business.bookService.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.model.decisionTree.NodeBookiceSchedineL2;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyBookiceNodeSchedineL2 extends ActionLazyTemplate<BookiceInfo, BookiceInfo> {
	
	public LazyBookiceNodeSchedineL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<BookiceInfo> translateRecordInfosHook(List<BookiceInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<BookiceInfo> getInstanceOfActionHook(DeciTreeOption<BookiceInfo> option) {
		return new NodeBookiceSchedineL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<BookiceInfo> translateResultHook(DeciResult<BookiceInfo> result) {
		return result;
	}
}
