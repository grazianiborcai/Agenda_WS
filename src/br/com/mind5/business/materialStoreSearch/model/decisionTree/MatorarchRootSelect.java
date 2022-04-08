package br.com.mind5.business.materialStoreSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSearch.model.action.MatorarchVisiMergeToSelect;
import br.com.mind5.business.materialStoreSearch.model.checker.MatorarchCheckLangu;
import br.com.mind5.business.materialStoreSearch.model.checker.MatorarchCheckOwner;
import br.com.mind5.business.materialStoreSearch.model.checker.MatorarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatorarchRootSelect extends DeciTreeTemplateRead<MatorarchInfo> {
	
	public MatorarchRootSelect(DeciTreeOption<MatorarchInfo> option) {
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatorarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatorarchInfo> option) {
		List<ActionStd<MatorarchInfo>> actions = new ArrayList<>();
		
		ActionStd<MatorarchInfo> select = new ActionStdCommom<MatorarchInfo>(option, MatorarchVisiMergeToSelect.class);
		actions.add(select);
		
		return actions;
	}
}
