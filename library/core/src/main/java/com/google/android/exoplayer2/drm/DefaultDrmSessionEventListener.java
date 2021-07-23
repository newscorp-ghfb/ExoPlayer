package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.MediaSource;

public interface DefaultDrmSessionEventListener extends DrmSessionEventListener {

  /** Called each time a drm session is acquired. */
  default void onDrmSessionAcquired() {}

  /** Called each time keys are loaded. */
  default void onDrmKeysLoaded() {}

  /**
   * Called when a drm error occurs.
   *
   * <p>This method being called does not indicate that playback has failed, or that it will fail.
   * The player may be able to recover from the error and continue. Hence applications should
   * <em>not</em> implement this method to display a user visible error or initiate an application
   * level retry ({@link Player.EventListener#onPlayerError} is the appropriate place to implement
   * such behavior). This method is called to provide the application with an opportunity to log the
   * error if it wishes to do so.
   *
   * @param error The corresponding exception.
   */
  default void onDrmSessionManagerError(Exception error) {}

  /** Called each time offline keys are restored. */
  default void onDrmKeysRestored() {}

  /** Called each time offline keys are removed. */
  default void onDrmKeysRemoved() {}

  /** Called each time a drm session is released. */
  default void onDrmSessionReleased() {}

  @Override
  default void onDrmSessionAcquired(int windowIndex,
      @Nullable MediaSource.MediaPeriodId mediaPeriodId,
      int state) {
    DrmSessionEventListener.super.onDrmSessionAcquired(windowIndex, mediaPeriodId, state);
    onDrmSessionAcquired();
  }

  @Override
  default void onDrmKeysLoaded(int windowIndex,
      @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
    DrmSessionEventListener.super.onDrmKeysLoaded(windowIndex, mediaPeriodId);
    onDrmKeysLoaded();
  }

  @Override
  default void onDrmSessionManagerError(int windowIndex,
      @Nullable MediaSource.MediaPeriodId mediaPeriodId,
      Exception error) {
    DrmSessionEventListener.super.onDrmSessionManagerError(windowIndex, mediaPeriodId, error);
    onDrmSessionManagerError(error);
  }

  @Override
  default void onDrmKeysRestored(int windowIndex,
      @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
    DrmSessionEventListener.super.onDrmKeysRestored(windowIndex, mediaPeriodId);
    onDrmKeysRestored();
  }

  @Override
  default void onDrmKeysRemoved(int windowIndex,
      @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
    DrmSessionEventListener.super.onDrmKeysRemoved(windowIndex, mediaPeriodId);
    onDrmKeysRemoved();
  }

  @Override
  default void onDrmSessionReleased(int windowIndex,
      @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
    DrmSessionEventListener.super.onDrmSessionReleased(windowIndex, mediaPeriodId);
    onDrmSessionReleased();
  }
}
