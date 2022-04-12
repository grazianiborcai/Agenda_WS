package br.com.mind5.business.storeTextDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.business.storeTextDefault.model.action.StorextaultVisiMergeToSelect;
import br.com.mind5.business.storeTextDefault.model.checker.StorextaultCheckOwner;
import br.com.mind5.business.storeTextDefault.model.checker.StorextaultCheckRead;
import br.com.mind5.business.storeTextDefault.model.checker.StorextaultCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StorextaultRootSelect extends DeciTreeTemplateRead<StorextaultInfo> {
	
	public StorextaultRootSelect(DeciTreeOption<StorextaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorextaultInfo> buildCheckerHook(DeciTreeOption<StorextaultInfo> option) {
		List<ModelChecker<StorextaultInfo>> queue = new ArrayList<>();		
		ModelChecker<StorextaultInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextaultCheckRead(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextaultCheckOwner(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextaultCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextaultInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextaultInfo> option) {
		List<ActionStd<StorextaultInfo>> actions = new ArrayList<>();
		
		ActionStd<StorextaultInfo> select = new ActionStdCommom<StorextaultInfo>(option, StorextaultVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
