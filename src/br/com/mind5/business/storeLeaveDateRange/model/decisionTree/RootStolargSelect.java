package br.com.mind5.business.storeLeaveDateRange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.model.action.StdStolargMergeToSelect;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckLangu;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckOwner;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckRead;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public class RootStolargSelect extends DeciTreeReadTemplate<StolargInfo> {
	
	public RootStolargSelect(DeciTreeOption<StolargInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolargInfo> buildDecisionCheckerHook(DeciTreeOption<StolargInfo> option) {
		List<ModelChecker<StolargInfo>> queue = new ArrayList<>();		
		ModelChecker<StolargInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StolargCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolargCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolargCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolargCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolargInfo>> buildActionsOnPassedHook(DeciTreeOption<StolargInfo> option) {
		List<ActionStd<StolargInfo>> actions = new ArrayList<>();
		
		ActionStd<StolargInfo> select = new StdStolargMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
