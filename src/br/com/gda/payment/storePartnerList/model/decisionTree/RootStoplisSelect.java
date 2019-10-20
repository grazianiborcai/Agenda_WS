package br.com.gda.payment.storePartnerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.storePartnerList.info.StoplisInfo;
import br.com.gda.payment.storePartnerList.model.action.LazyStoplisMergePaypar;
import br.com.gda.payment.storePartnerList.model.action.StdStoplisMergeToSelect;
import br.com.gda.payment.storePartnerList.model.checker.StoplisCheckOwner;
import br.com.gda.payment.storePartnerList.model.checker.StoplisCheckRead;
import br.com.gda.payment.storePartnerList.model.checker.StoplisCheckStorauth;
import br.com.gda.payment.storePartnerList.model.checker.StoplisCheckStore;

public final class RootStoplisSelect extends DeciTreeReadTemplate<StoplisInfo> {
	
	public RootStoplisSelect(DeciTreeOption<StoplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoplisInfo> buildDecisionCheckerHook(DeciTreeOption<StoplisInfo> option) {
		List<ModelChecker<StoplisInfo>> queue = new ArrayList<>();		
		ModelChecker<StoplisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoplisCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoplisCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoplisCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoplisCheckStorauth(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoplisInfo>> buildActionsOnPassedHook(DeciTreeOption<StoplisInfo> option) {
		List<ActionStd<StoplisInfo>> actions = new ArrayList<>();
		
		ActionStd<StoplisInfo> select = new StdStoplisMergeToSelect(option);
		ActionLazy<StoplisInfo> mergePayPartner = new LazyStoplisMergePaypar(option.conn, option.schemaName);
		
		select.addPostAction(mergePayPartner);
		
		actions.add(select);
		return actions;
	}
}
