package org.mycompany.afiliacion.domain;

import org.mycompany.afiliacion.domain.RewardConfirmation;

import org.mycompany.afiliacion.domain.Suscripcion;;


public interface RewardRepository {


	public  RewardConfirmation confirmReward( String suscrip , Suscripcion suscripcion);
}