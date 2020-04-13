package br.com.mind5.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatRootSelect;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatMergeEmpmarch;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootEmpmatSearch extends DeciTreeTemplateReadV1<EmpmatInfo> {
	
	public RootEmpmatSearch(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpmatInfo> buildCheckerHook(DeciTreeOption<EmpmatInfo> option) {
		List<ModelCheckerV1<EmpmatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpmatInfo> checker;
			
		checker = new EmpmatCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStdV1<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmpmatInfo> mergeEmpmarch = new StdEmpmatMergeEmpmarch(option);
		ActionLazyV1<EmpmatInfo> select = new LazyEmpmatRootSelect(option.conn, option.schemaName);
		
		mergeEmpmarch.addPostAction(select);
		
		actions.add(mergeEmpmarch);
		return actions;
	}
}
