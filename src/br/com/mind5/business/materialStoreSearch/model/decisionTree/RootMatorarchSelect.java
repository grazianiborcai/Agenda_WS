package br.com.mind5.business.materialStoreSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSearch.model.action.StdMatorarchMergeToSelect;
import br.com.mind5.business.materialStoreSearch.model.checker.MatorarchCheckLangu;
import br.com.mind5.business.materialStoreSearch.model.checker.MatorarchCheckOwner;
import br.com.mind5.business.materialStoreSearch.model.checker.MatorarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatorarchSelect extends DeciTreeReadTemplate<MatorarchInfo> {
	
	public RootMatorarchSelect(DeciTreeOption<MatorarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatorarchInfo> buildCheckerHook(DeciTreeOption<MatorarchInfo> option) {
		ModelCheckerOption checkerOption;
		List<ModelChecker<MatorarchInfo>> queue = new ArrayList<>();		
		ModelChecker<MatorarchInfo> checker;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatorarchCheckRead(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatorarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatorarchCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatorarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatorarchInfo> option) {
		List<ActionStdV1<MatorarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatorarchInfo> select = new StdMatorarchMergeToSelect(option);
		actions.add(select);
		
		return actions;
	}
}
