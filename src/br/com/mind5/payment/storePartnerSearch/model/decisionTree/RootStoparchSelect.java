package br.com.mind5.payment.storePartnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSearch.model.action.StdStoparchMergeToSelect;
import br.com.mind5.payment.storePartnerSearch.model.checker.StoparchCheckOwner;
import br.com.mind5.payment.storePartnerSearch.model.checker.StoparchCheckRead;

public final class RootStoparchSelect extends DeciTreeTemplateRead<StoparchInfo> {
	
	public RootStoparchSelect(DeciTreeOption<StoparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparchInfo> buildCheckerHook(DeciTreeOption<StoparchInfo> option) {
		List<ModelChecker<StoparchInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoparchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoparchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoparchInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparchInfo> option) {
		List<ActionStd<StoparchInfo>> actions = new ArrayList<>();
		
		ActionStd<StoparchInfo> select = new StdStoparchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
