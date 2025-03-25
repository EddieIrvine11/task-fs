import {httpClient} from "./client";

export const sendCommunicate = data => httpClient.post("/api/", data);
