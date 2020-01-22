package com.welldoc.domain.bloodpressure.elog;

import com.welldoc.domain.core.elog.ElogEntry;
import com.welldoc.domain.core.observationmodel.Observation;
import com.welldoc.domain.diabetes.elog.Note;
import com.welldoc.framework.Entity;
import com.welldoc.framework.IDateTime;
import com.welldoc.framework.IRuntimeTypeIdentifier;
import com.welldoc.framework.PlatformFactoryLocator;
import com.welldoc.framework.exceptions.DomainException;

public class BPElogEntry extends ElogEntry {

    public static final String CLASS_NAME = "BPElogEntry";

    private BloodPressure bp;

    public BPElogEntry(String entryId) {
        super(entryId);
        this.bp = null;
    }

    public BloodPressure GetBloodPressure() {
        return bp;
    }

    public void SetBloodPressure(BloodPressure bp) {
        this.bp = bp;
        if (bp != null) {
            bp.SetEntryId(this.entryId);
            bp.SetEntryDateTime(PlatformFactoryLocator.GetPlatformFactory().CreateDateTime());
        }
    }

    public void PopulateCachedObjects() {
        cachedPatientId = GetPatientId();
        cachedObservedDateTime = GetObservationDateTime();
        cachedTimeZoneId = GetTimeZoneId();
        cachedTimeZoneOffsetInMinutes = GetTimeZoneOffsetInMinutes();
        cachedSourceType = GetSourceType();
        cachedCreatedBy = GetCreatedBy();
    }

    public int GetObservationStatus() {
        int status = Observation.STATUS_DELETED;
        if (bp != null) {
            status = bp.GetStatus();
        } else if (freeTextComment != null) {
            status = freeTextComment.GetStatus();
        } else if (noteList.Count() > 0) {
            status = ((Note) noteList.GetItem(0)).GetStatus();
        }
        return status;
    }

    @Override
    public void SetPatientId(long patientId) {
        super.SetPatientId(patientId);
        if (bp != null) {
            bp.SetPatientId(patientId);
        }
    }

    @Override
    public long GetPatientId() {
        long patientId = super.GetPatientId();
        if (bp != null) {
            patientId = bp.GetPatientId();
        } else if (freeTextComment != null) {
            patientId = freeTextComment.GetPatientId();
        } else if (noteList.Count() > 0) {
            patientId = ((Note) noteList.GetItem(0)).GetPatientId();
        }
        return patientId;
    }

    @Override
    public void SetObservationDateTime(IDateTime dateTime) {
        super.SetObservationDateTime(dateTime);
        if (bp != null) {
            bp.SetObservationDateTime(dateTime);
        }
    }

    @Override
    public IDateTime GetObservationDateTime() {
        IDateTime dateTime = super.GetObservationDateTime();
        if (bp != null) {
            dateTime = bp.GetObservationDateTime();
        } else if (freeTextComment != null) {
            dateTime = freeTextComment.GetObservationDateTime();
        } else if (noteList.Count() > 0) {
            dateTime = ((Note) noteList.GetItem(0)).GetObservationDateTime();
        }
        return dateTime;
    }

    @Override
    public void SetTimeZoneId(String timeZoneId) {
        super.SetTimeZoneId(timeZoneId);
        if (bp != null) {
            bp.SetTimeZoneId(timeZoneId);
        }
    }

    @Override
    public String GetTimeZoneId() {
        String timeZoneId = super.GetTimeZoneId();
        if (bp != null) {
            timeZoneId = bp.GetTimeZoneId();
        } else if (freeTextComment != null) {
            timeZoneId = freeTextComment.GetTimeZoneId();
        } else if (noteList.Count() > 0) {
            timeZoneId = ((Note) noteList.GetItem(0)).GetTimeZoneId();
        }
        return timeZoneId;
    }

    @Override
    public void SetTimeZoneOffsetInMinutes(int timeZoneOffsetInMinutes) {
        super.SetTimeZoneOffsetInMinutes(timeZoneOffsetInMinutes);
        if (bp != null) {
            bp.SetTimeZoneOffsetInMinutes(timeZoneOffsetInMinutes);
        }
    }

    @Override
    public int GetTimeZoneOffsetInMinutes() {
        int timeZoneOffsetInMinutes = super.GetTimeZoneOffsetInMinutes();
        if (bp != null) {
            timeZoneOffsetInMinutes = bp.GetTimeZoneOffsetInMinutes();
        } else if (freeTextComment != null) {
            timeZoneOffsetInMinutes = freeTextComment.GetTimeZoneOffsetInMinutes();
        } else if (noteList.Count() > 0) {
            timeZoneOffsetInMinutes = ((Note) noteList.GetItem(0)).GetTimeZoneOffsetInMinutes();
        }
        return timeZoneOffsetInMinutes;
    }

    @Override
    public void SetSourceType(int sourceType) {
        super.SetSourceType(sourceType);
        if (bp != null) {
            bp.SetSourceType(sourceType);
        }
    }

    @Override
    public int GetSourceType() {
        int sourceType = super.GetSourceType();
        if (bp != null) {
            sourceType = bp.GetSourceType();
        } else if (freeTextComment != null) {
            sourceType = freeTextComment.GetSourceType();
        } else if (noteList.Count() > 0) {
            sourceType = ((Note) noteList.GetItem(0)).GetSourceType();
        }
        return sourceType;
    }

    @Override
    public void SetCreatedBy(String createdBy) {
        super.SetCreatedBy(createdBy);
        if (bp != null) {
            bp.SetCreatedBy(createdBy);
        }
    }

    @Override
    public String GetCreatedBy() {
        String createdBy = super.GetCreatedBy();
        if (bp != null) {
            createdBy = bp.GetCreatedBy();
        } else if (freeTextComment != null) {
            createdBy = freeTextComment.GetCreatedBy();
        } else if (noteList.Count() > 0) {
            createdBy = ((Note) noteList.GetItem(0)).GetCreatedBy();
        }
        return createdBy;
    }

    @Override
    public void SetEditEntry(boolean isEditEntry) {
        super.SetEditEntry(isEditEntry);
        if (bp != null) {
            bp.SetEditEntry(isEditEntry);
        }
        if (isEditEntry) {
            UpdateCachedVariables();
        }
    }

    @Override
    public Entity DeepCloneEntity() {
        BPElogEntry bpElogEntry = new BPElogEntry(entryId);
        DeepCopy(this, bpElogEntry);
        return bpElogEntry;
    }

    protected void DeepCopy(BPElogEntry source, BPElogEntry destination) {
        try {
            super.DeepCopy(source, destination);
            if (source.bp != null) {
                try {
                    BloodPressure bp = (BloodPressure) source.bp.DeepCloneEntity();
                    destination.SetBloodPressure(bp);
                } catch (DomainException e) {
                }
            }
        } catch (DomainException e) {

        }
    }

    @Override
    public boolean CompareEntity(Entity entry) {
        boolean result = false;
        IRuntimeTypeIdentifier runTypeId = PlatformFactoryLocator.GetPlatformFactory()
                .CreateRuntimeTypeIdentification();
        if (runTypeId.CompareTypes(this, entry)) {
            result = Compare((BPElogEntry) entry, this);
        }
        return result;
    }

    protected boolean Compare(BPElogEntry entryOne, BPElogEntry entryTwo) {
        boolean result = false;
        if (entryOne != null && entryTwo != null) {
            if (super.Compare(entryOne, entryTwo) && CompareBloodPressure(entryOne
                    .GetBloodPressure(), entryTwo.GetBloodPressure())) {
                result = true;
            }
        }
        return result;
    }

    private boolean CompareBloodPressure(BloodPressure source, BloodPressure destination) {
        boolean status = false;
        if (source != null) {
            status = source.CompareEntity(destination);
        } else if (destination == null) {
            status = true;
        }
        return status;
    }

    @Override
    public String GetClassName() {
        return CLASS_NAME;
    }

}
