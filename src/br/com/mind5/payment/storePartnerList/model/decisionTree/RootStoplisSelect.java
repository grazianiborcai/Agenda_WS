package br.com.mind5.payment.storePartnerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.model.action.LazyStoplisMergePaypar;
import br.com.mind5.payment.storePartnerList.model.action.StdStoplisMergeToSelect;
import br.com.mind5.payment.storePartnerList.model.checker.StoplisCheckOwner;
import br.com.mind5.payment.storePartnerList.model.checker.StoplisCheckRead;
import br.com.mind5.payment.storePartnerList.model.checker.StoplisCheckStore;

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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoplisInfo>> buildActionsOnPassedHook(DeciTreeOption<StoplisInfo> option) {
		List<ActionStdV1<StoplisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoplisInfo> select = new StdStoplisMergeToSelect(option);
		ActionLazyV1<StoplisInfo> mergePayPartner = new LazyStoplisMergePaypar(option.conn, option.schemaName);
		
		select.addPostAction(mergePayPartner);
		
		actions.add(select);
		return actions;
	}
}
