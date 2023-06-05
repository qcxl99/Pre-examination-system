import com.isep.appointement.Repository.DoctorRepository;
import com.isep.appointement.controller.Reservation.AppointmentController;
import com.isep.appointement.controller.doctor.DoctorService;
import com.isep.appointement.controller.patient.PatientService;
import com.isep.appointement.model.Reservation;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@WebMvcTest(AppointmentController.class)
public class AppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Reservation appointmentService;

    @MockBean
    private PatientService patientService;

    @MockBean
    private DoctorRepository doctorRepository;

    @MockBean
    private DoctorService doctorService;
    @InjectMocks
    private AppointmentController appointmentController;

    @Test
    @WithMockUser
    public void showAllAppointmentByKeyword_ShouldReturnAppointmentPage() throws Exception {
        mockMvc.perform(get("/appointment")
                .param("keywordApp", "test")
                .param("page", "0")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(view().name("Appointment"))
                .andExpect(model().attributeExists("reservations"));
    }

    @Test
    @WithMockUser
    public void showPending_ShouldReturnAppointmentPage() throws Exception {
        mockMvc.perform(get("/appointment/pending")
                .param("page", "0")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(view().name("Appointment"))
                .andExpect(model().attributeExists("reservations"));
    }

    @Test
    @WithMockUser
    public void addAppointment_ShouldReturnAddAppointmentPage() throws Exception {
        mockMvc.perform(get("/appointment/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("add_appointment"))
                .andExpect(model().attributeExists("reservation"));
    }

    // Add more test methods for other URLs in the AppointmentController
    @Test
    public void addAppointment_shouldReturnAddAppointmentTemplate() {
        // Arrange
        Model model = Mockito.mock(Model.class);

        // Act
        String result = appointmentController.addAppointment(model);

        // Assert
        assertThat(result).isEqualTo("add_appointment");
        verify(model).addAttribute("reservation", new Reservation());
    }
}
