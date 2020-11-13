package br.com.mind5.business.employeeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.model.action.LazyEmpnapDaoInsert;
import br.com.mind5.business.employeeSnapshot.model.action.LazyEmpnapMergeUselis;
import br.com.mind5.business.employeeSnapshot.model.action.StdEmpnapMergePersolis;
import br.com.mind5.business.employeeSnapshot.model.checker.EmpnapCheckEmp;
import br.com.mind5.business.employeeSnapshot.model.checker.EmpnapCheckLangu;
import br.com.mind5.business.employeeSnapshot.model.checker.EmpnapCheckOwner;
import br.com.mind5.business.employeeSnapshot.model.checker.EmpnapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmpnapInsert extends DeciTreeTemplateWriteV2<EmpnapInfo> {	
	
	public RootEmpnapInsert(DeciTreeOption<EmpnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpnapInfo> buildCheckerHook(DeciTreeOption<EmpnapInfo> option) {
		List<ModelCheckerV1<EmpnapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpnapInfo> checker;
		ModelCheckerOption checkerOption;		

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpnapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpnapCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpnapCheckEmp(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpnapInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpnapInfo> option) {
		List<ActionStdV1<EmpnapInfo>> actions = new ArrayList<>();

		ActionStdV1<EmpnapInfo> mergePersolis = new StdEmpnapMergePersolis(option);
		ActionLazy<EmpnapInfo> mergeUselis = new LazyEmpnapMergeUselis(option.conn, option.schemaName);
		ActionLazy<EmpnapInfo> insert = new LazyEmpnapDaoInsert(option.conn, option.schemaName);
		
		mergePersolis.addPostAction(mergeUselis);
		mergeUselis.addPostAction(insert);
		
		actions.add(mergePersolis);	
		return actions;
	}
}
