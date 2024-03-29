package br.com.mind5.business.materialMovementSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.materialMovementSearch.model.action.MatmarchVisiMergeToSelect;
import br.com.mind5.business.materialMovementSearch.model.checker.MatmarchCheckLangu;
import br.com.mind5.business.materialMovementSearch.model.checker.MatmarchCheckOwner;
import br.com.mind5.business.materialMovementSearch.model.checker.MatmarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class MatmarchRootSelect extends DeciTreeTemplateRead<MatmarchInfo> {
	
	public MatmarchRootSelect(DeciTreeOption<MatmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatmarchInfo> buildCheckerHook(DeciTreeOption<MatmarchInfo> option) {
		List<ModelChecker<MatmarchInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatmarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmarchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatmarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmarchInfo> option) {
		List<ActionStd<MatmarchInfo>> actions = new ArrayList<>();

		ActionStd<MatmarchInfo> select = new ActionStdCommom<MatmarchInfo>(option, MatmarchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
