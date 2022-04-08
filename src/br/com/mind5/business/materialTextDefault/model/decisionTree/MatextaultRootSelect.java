package br.com.mind5.business.materialTextDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextDefault.model.action.MatextaultVisiMergeToSelect;
import br.com.mind5.business.materialTextDefault.model.checker.MatextaultCheckMat;
import br.com.mind5.business.materialTextDefault.model.checker.MatextaultCheckOwner;
import br.com.mind5.business.materialTextDefault.model.checker.MatextaultCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatextaultRootSelect extends DeciTreeTemplateRead<MatextaultInfo> {
	
	public MatextaultRootSelect(DeciTreeOption<MatextaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextaultInfo> buildCheckerHook(DeciTreeOption<MatextaultInfo> option) {
		List<ModelChecker<MatextaultInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextaultInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextaultCheckRead(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextaultCheckOwner(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextaultCheckMat(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextaultInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextaultInfo> option) {
		List<ActionStd<MatextaultInfo>> actions = new ArrayList<>();
		
		ActionStd<MatextaultInfo> select = new ActionStdCommom<MatextaultInfo>(option, MatextaultVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
