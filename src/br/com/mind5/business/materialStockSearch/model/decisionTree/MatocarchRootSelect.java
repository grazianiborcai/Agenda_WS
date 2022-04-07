package br.com.mind5.business.materialStockSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.business.materialStockSearch.model.action.MatocarchVisiMergeToSelect;
import br.com.mind5.business.materialStockSearch.model.checker.MatocarchCheckLangu;
import br.com.mind5.business.materialStockSearch.model.checker.MatocarchCheckOwner;
import br.com.mind5.business.materialStockSearch.model.checker.MatocarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class MatocarchRootSelect extends DeciTreeTemplateRead<MatocarchInfo> {
	
	public MatocarchRootSelect(DeciTreeOption<MatocarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatocarchInfo> buildCheckerHook(DeciTreeOption<MatocarchInfo> option) {
		List<ModelChecker<MatocarchInfo>> queue = new ArrayList<>();		
		ModelChecker<MatocarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatocarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatocarchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatocarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatocarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatocarchInfo> option) {
		List<ActionStd<MatocarchInfo>> actions = new ArrayList<>();

		ActionStd<MatocarchInfo> select = new ActionStdCommom<MatocarchInfo>(option, MatocarchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
