package br.com.mind5.business.bookService.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.model.decisionTree.NodeBookiceServiceL2;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyBookiceNodeServiceL2 extends ActionLazyTemplateV2<BookiceInfo, BookiceInfo> {
	
	public LazyBookiceNodeServiceL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<BookiceInfo> translateRecordInfosHook(List<BookiceInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<BookiceInfo> getInstanceOfActionHook(DeciTreeOption<BookiceInfo> option) {
		return new NodeBookiceServiceL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<BookiceInfo> translateResultHook(DeciResult<BookiceInfo> result) {
		return result;
	}
}
