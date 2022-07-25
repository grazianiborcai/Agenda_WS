package br.com.mind5.masterData.materialType.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialType.model.action.MatypeVisiDaoSelect;
import br.com.mind5.masterData.materialType.model.checker.MatypeCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatypeRootSelect extends DeciTreeTemplateRead<MatypeInfo> {
	
	public MatypeRootSelect(DeciTreeOption<MatypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatypeInfo> buildCheckerHook(DeciTreeOption<MatypeInfo> option) {
		List<ModelChecker<MatypeInfo>> queue = new ArrayList<>();		
		ModelChecker<MatypeInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatypeCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatypeInfo>> buildActionsOnPassedHook(DeciTreeOption<MatypeInfo> option) {
		List<ActionStd<MatypeInfo>> actions = new ArrayList<>();
		
		ActionStd<MatypeInfo> select = new ActionStdCommom<MatypeInfo>(option, MatypeVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
