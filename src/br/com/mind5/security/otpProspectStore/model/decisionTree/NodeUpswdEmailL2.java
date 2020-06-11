package br.com.mind5.security.otpProspectStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.action.StdOtporeSuccess_;
import br.com.mind5.security.otpProspectStore.model.checker.UpswdCheckHasEmail;
import br.com.mind5.security.otpProspectStore.model.checker.UpswdCheckHasPerson;

public final class NodeUpswdEmailL2 extends DeciTreeTemplateWriteV2<OtporeInfo> {
	
	public NodeUpswdEmailL2(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OtporeInfo> buildCheckerHook(DeciTreeOption<OtporeInfo> option) {
		List<ModelCheckerV1<OtporeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OtporeInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new UpswdCheckHasPerson(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UpswdCheckHasEmail(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OtporeInfo>> buildActionsOnPassedHook(DeciTreeOption<OtporeInfo> option) {
		List<ActionStdV1<OtporeInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OtporeInfo> success = new StdOtporeSuccess_(option);
		//TODO: enviar e-mail
		
		actions.add(success);		
		return actions;
	}
}
