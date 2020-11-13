package br.com.mind5.payment.countryPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.model.action.LazyCounparMergePaypar;
import br.com.mind5.payment.countryPartner.model.action.StdCounparDaoSelect;
import br.com.mind5.payment.countryPartner.model.checker.CounparCheckRead;

public final class RootCounparSelect extends DeciTreeTemplateReadV2<CounparInfo> {
	
	public RootCounparSelect(DeciTreeOption<CounparInfo> option) {
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
		checker = new CounparCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CounparInfo>> buildActionsOnPassedHook(DeciTreeOption<CounparInfo> option) {
		List<ActionStdV1<CounparInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CounparInfo> select = new StdCounparDaoSelect(option);
		ActionLazy<CounparInfo> mergePayPartner = new LazyCounparMergePaypar(option.conn, option.schemaName);
		
		select.addPostAction(mergePayPartner);
		
		actions.add(select);
		return actions;
	}
}
