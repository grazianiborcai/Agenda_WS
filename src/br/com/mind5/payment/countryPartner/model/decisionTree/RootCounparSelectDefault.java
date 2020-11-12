package br.com.mind5.payment.countryPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.model.action.LazyCounparMergeCounparch;
import br.com.mind5.payment.countryPartner.model.action.LazyCounparRootSelect;
import br.com.mind5.payment.countryPartner.model.action.StdCounparEnforceDefault;
import br.com.mind5.payment.countryPartner.model.checker.CounparCheckDefault;

public final class RootCounparSelectDefault extends DeciTreeTemplateReadV2<CounparInfo> {
	
	public RootCounparSelectDefault(DeciTreeOption<CounparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CounparInfo> buildCheckerHook(DeciTreeOption<CounparInfo> option) {
		List<ModelCheckerV1<CounparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CounparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CounparCheckDefault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CounparInfo>> buildActionsOnPassedHook(DeciTreeOption<CounparInfo> option) {
		List<ActionStdV1<CounparInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CounparInfo> enforceDefault = new StdCounparEnforceDefault(option);
		ActionLazyV1<CounparInfo> mergeCounparch = new LazyCounparMergeCounparch(option.conn, option.schemaName);
		ActionLazyV1<CounparInfo> select = new LazyCounparRootSelect(option.conn, option.schemaName);
		
		enforceDefault.addPostAction(mergeCounparch);
		mergeCounparch.addPostAction(select);
		
		actions.add(enforceDefault);
		return actions;
	}
}
