package br.com.mind5.discount.discountStoreSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.discount.discountStoreSnapshot.model.action.DisorapVisiMergeDisegy;
import br.com.mind5.discount.discountStoreSnapshot.model.action.DisorapVisiMergeToSelect;
import br.com.mind5.discount.discountStoreSnapshot.model.checker.DisorapCheckLangu;
import br.com.mind5.discount.discountStoreSnapshot.model.checker.DisorapCheckOwner;
import br.com.mind5.discount.discountStoreSnapshot.model.checker.DisorapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class DisorapRootSelect extends DeciTreeTemplateRead<DisorapInfo> {
	
	public DisorapRootSelect(DeciTreeOption<DisorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DisorapInfo> buildCheckerHook(DeciTreeOption<DisorapInfo> option) {
		List<ModelChecker<DisorapInfo>> queue = new ArrayList<>();		
		ModelChecker<DisorapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new DisorapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisorapCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisorapCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DisorapInfo>> buildActionsOnPassedHook(DeciTreeOption<DisorapInfo> option) {
		List<ActionStd<DisorapInfo>> actions = new ArrayList<>();
		
		ActionStd<DisorapInfo> select = new ActionStdCommom<DisorapInfo>(option, DisorapVisiMergeToSelect.class);
		ActionLazy<DisorapInfo> mergeDisegy = new ActionLazyCommom<DisorapInfo>(option, DisorapVisiMergeDisegy.class);
		
		select.addPostAction(mergeDisegy);
		
		actions.add(select);
		return actions;
	}
}
