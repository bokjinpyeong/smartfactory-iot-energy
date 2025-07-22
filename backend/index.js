const express = require("express");
const cors    = require("cors");
require("dotenv").config();

const app  = express();
const port = process.env.PORT || 5000;

app.use(cors());
app.use(express.json());

app.get("/health", (_, res) => res.json({ status: "ok" }));

// TODO: 라우트 추가 ( /auth, /data 등)

app.listen(port, "0.0.0.0", () =>
  console.log(`🚀 Backend listening on ${port}`)
);
