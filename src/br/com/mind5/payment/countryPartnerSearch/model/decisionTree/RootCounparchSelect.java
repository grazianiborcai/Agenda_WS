package br.com.mind5.payment.countryPartnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;
import br.com.mind5.payment.countryPartnerSearch.model.action.StdCounparchSelect;
import br.com.mind5.payment.countryPartnerSearch.model.checker.CounparchCheckRead;

public final class RootCounparchSelect extends DeciTreeReadTemplate<CounparchInfo> {
	
	public RootCounparchSelect(DeciTreeOption<CounparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CounparchInfo> buildDecisionCheckerHook(DeciTreeOption<CounparchInfo> option) {
		List<ModelChecker<CounparchInfo>> queue = new ArrayList<>();		
		ModelChecker<CounparchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CounparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CounparchInfo>> buildActionsOnPassedHook(DeciTreeOption<CounparchInfo> option) {
		List<ActionStd<CounparchInfo>> actions = new ArrayList<>();
		
		ActionStd<CounparchInfo> select = new StdCounparchSelect(option);
		
		actions.add(select);
		return actions;
	}
}
