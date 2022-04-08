package br.com.mind5.business.materialTextSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.business.materialTextSnapshot.model.action.MatextsnapVisiMergeToSelect;
import br.com.mind5.business.materialTextSnapshot.model.checker.MatextsnapCheckMat;
import br.com.mind5.business.materialTextSnapshot.model.checker.MatextsnapCheckOwner;
import br.com.mind5.business.materialTextSnapshot.model.checker.MatextsnapCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatextsnapRootSelect extends DeciTreeTemplateRead<MatextsnapInfo> {
	
	public MatextsnapRootSelect(DeciTreeOption<MatextsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextsnapInfo> buildCheckerHook(DeciTreeOption<MatextsnapInfo> option) {
		List<ModelChecker<MatextsnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextsnapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextsnapCheckRead(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextsnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextsnapCheckMat(checkerOption);
		queue.add(checker);		
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextsnapInfo> option) {
		List<ActionStd<MatextsnapInfo>> actions = new ArrayList<>();
		
		ActionStd<MatextsnapInfo> select = new ActionStdCommom<MatextsnapInfo>(option, MatextsnapVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
