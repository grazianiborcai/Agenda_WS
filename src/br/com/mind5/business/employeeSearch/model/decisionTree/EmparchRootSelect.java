package br.com.mind5.business.employeeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.action.EmparchVisiMergeToSelect;
import br.com.mind5.business.employeeSearch.model.checker.EmparchCheckLangu;
import br.com.mind5.business.employeeSearch.model.checker.EmparchCheckOwner;
import br.com.mind5.business.employeeSearch.model.checker.EmparchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmparchRootSelect extends DeciTreeTemplateRead<EmparchInfo> {
	
	public EmparchRootSelect(DeciTreeOption<EmparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmparchInfo> buildCheckerHook(DeciTreeOption<EmparchInfo> option) {
		List<ModelChecker<EmparchInfo>> queue = new ArrayList<>();		
		ModelChecker<EmparchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmparchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmparchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmparchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmparchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmparchInfo> option) {
		List<ActionStd<EmparchInfo>> actions = new ArrayList<>();

		ActionStd<EmparchInfo> select = new ActionStdCommom<EmparchInfo>(option, EmparchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
