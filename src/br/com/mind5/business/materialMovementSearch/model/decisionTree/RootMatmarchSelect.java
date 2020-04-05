package br.com.mind5.business.materialMovementSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.materialMovementSearch.model.action.StdMatmarchMergeToSelect;
import br.com.mind5.business.materialMovementSearch.model.checker.MatmarchCheckLangu;
import br.com.mind5.business.materialMovementSearch.model.checker.MatmarchCheckOwner;
import br.com.mind5.business.materialMovementSearch.model.checker.MatmarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;


public final class RootMatmarchSelect extends DeciTreeReadTemplate<MatmarchInfo> {
	
	public RootMatmarchSelect(DeciTreeOption<MatmarchInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatmarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmarchInfo> option) {
		List<ActionStdV1<MatmarchInfo>> actions = new ArrayList<>();

		ActionStdV1<MatmarchInfo> select = new StdMatmarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
