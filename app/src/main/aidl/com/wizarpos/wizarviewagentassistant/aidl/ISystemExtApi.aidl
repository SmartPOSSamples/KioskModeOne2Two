package com.wizarpos.wizarviewagentassistant.aidl;
interface ISystemExtApi{
 	/**
     * Get the preferred network type.
     * Used for device configuration by some CDMA operators.
     * <p>
     * Requires Permission:
     *   {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE}
     * Or the calling app has carrier privileges. @see #hasCarrierPrivileges
     *
     * @return the preferred network type, defined in RILConstants.java.
     * @hide
     */
   int getPreferredNetworkType(int subId);
   /**
     * Set the preferred network type.
     * Used for device configuration by some CDMA operators.
     * <p>
     * Requires Permission:
     *   {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE}
     * Or the calling app has carrier privileges. @see #hasCarrierPrivileges
     *
     * @param subId the id of the subscription to set the preferred network type for.
     * @param networkType the preferred network type, defined in RILConstants.java.
     * @return true on success; false on any failure.
     * @hide
     */
   boolean setPreferredNetworkType(int subId, int networkType);
   /**
     * Request to put this activity in a mode where the user is locked to a restricted set of applications.
     * <p>
     * Requires Permission:
     *	{@link android.Manifest.permission#MANAGE_ACTIVITY_STACKS} 
     * @param taskid.
     * @return true on success; false on any failure.
     * @hide
     */
   boolean startLockTaskMode(int taskId);
}