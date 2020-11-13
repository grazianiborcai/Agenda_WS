package br.com.mind5.payment.countryPartnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;
import br.com.mind5.payment.countryPartnerSearch.model.action.StdCounparchDaoSelect;
import br.com.mind5.payment.countryPartnerSearch.model.checker.CounparchCheckRead;

public final class RootCounparchSelect extends DeciTreeTemplateReadV2<CounparchInfo> {
	
	public RootCounparchSelect(DeciTreeOption<CounparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CounparchInfo> buildCheckerHook(DeciTreeOption<CounparchInfo> option) {
		List<ModelCheckerV1<CounparchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CounparchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CounparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CounparchInfo>> buildActionsOnPassedHook(DeciTreeOption<CounparchInfo> option) {
		List<ActionStdV2<CounparchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CounparchInfo> select = new StdCounparchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
