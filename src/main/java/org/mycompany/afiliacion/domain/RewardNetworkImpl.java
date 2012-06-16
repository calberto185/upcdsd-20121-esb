package org.mycompany.afiliacion.domain;

import org.mycompany.afiliacion.domain.RewardConfirmation;
import org.mycompany.afiliacion.domain.RewardNetwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.mycompany.afiliacion.domain.Suscripcion;

@Service("rewardNetwork")
public class RewardNetworkImpl implements RewardNetwork {

	@Transactional
	public RewardConfirmation rewardAccountFor(Suscripcion suscripcion) {
		
		String suscrip = suscripcion.getCodigo();
		return RewardRepository.confirmReward(suscrip, suscripcion);
	}
}