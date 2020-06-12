package br.com.mind5.message.emailProspectStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailProspectStore.info.EmaproreInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmaproreSendEmail extends ActionLazyTemplateV2<EmaproreInfo, EmaproreInfo> {
	
	public LazyEmaproreSendEmail(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmaproreInfo> translateRecordInfosHook(List<EmaproreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmaproreInfo> getInstanceOfActionHook(DeciTreeOption<EmaproreInfo> option) {
		return new StdEmaproreSendEmail(option);
	}
	
	
	
	@Override protected DeciResult<EmaproreInfo> translateResultHook(DeciResult<EmaproreInfo> result) {
		return result;
	}
}
