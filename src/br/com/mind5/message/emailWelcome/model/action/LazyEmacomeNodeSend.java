package br.com.mind5.message.emailWelcome.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.model.decisionTree.NodeEmacomeSend;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmacomeNodeSend extends ActionLazyTemplateV2<EmacomeInfo, EmacomeInfo> {

	public LazyEmacomeNodeSend(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmacomeInfo> translateRecordInfosHook(List<EmacomeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmacomeInfo> getInstanceOfActionHook(DeciTreeOption<EmacomeInfo> option) {
		return new NodeEmacomeSend(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmacomeInfo> translateResultHook(DeciResult<EmacomeInfo> result) {
		return result;
	}
}